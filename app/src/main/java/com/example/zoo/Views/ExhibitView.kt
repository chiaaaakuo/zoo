package com.example.zoo.Views

import com.example.zoo.AppCore.Model.Plant

interface ExhibitView: ViewBase {
     fun onLoadFinished(plants:List<Plant>)
     fun onLoadError(error:String)
}