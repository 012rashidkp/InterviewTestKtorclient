package com.Test.interviewtest.presentation.states

import com.Test.interviewtest.domain.model.HomeData

data class MovieviewState(
    val loading: Boolean? = false,
    val status:String?=null,
    val list:List<HomeData?>?=null,
    val message:String?=null
)
