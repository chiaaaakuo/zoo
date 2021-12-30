package com.example.zoo.Interactors

import com.example.zoo.AppCore.Model.Exhibit
import com.example.zoo.AppCore.Model.Plant

class ExhibitInteractor {
    interface onFinishedLister {
        fun onSuccess(data: List<Plant>)
        fun onError(error:String)
    }

    fun loadData (onFinishedLister: onFinishedLister){

    }
}