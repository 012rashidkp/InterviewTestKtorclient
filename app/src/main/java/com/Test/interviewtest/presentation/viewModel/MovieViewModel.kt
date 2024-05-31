package com.Test.interviewtest.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Test.interviewtest.domain.network.Resource
import com.Test.interviewtest.domain.repository.MovieRepository
import com.Test.interviewtest.presentation.states.MovieviewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository):ViewModel() {
    private val _state = mutableStateOf(MovieviewState())
    val state: State<MovieviewState?> = _state

init {
    getMovieList()
}


    fun getMovieList(){
        Log.d("listitems... ","call")
        try {
            viewModelScope.launch{
                repository.getMovieList().collect{result->
                    Log.d("listitems... ","${result.message}")
                    when(result){
                        is Resource.Loading->{
                            Log.d("listitems... ","loading")
                            _state.value = state.value!!.copy(
                                loading = true
                            )
                        }
                        is Resource.Success->{
                            Log.d("listitems... ","${result.data?.homeData}")

                            _state.value=state.value!!.copy(
                                loading = false,
                                status  = result.data?.title,
                                list  = result.data?.homeData,
                            )


                        }
                        is Resource.Error->{
                            Log.d("listitems... ","error")

                            _state.value = state.value!!.copy(
                                loading  = false,
                                message = "Error Occurs"

                            )
                        }
                    }

                }


            }
        }catch (e:Exception){
            Log.d("listitems... ","${e.message}")

            _state.value = state.value!!.copy(
                loading  = false,
                message = "${e.message}"

            )
        }
    }


}