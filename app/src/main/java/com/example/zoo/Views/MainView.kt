package com.example.zoo.Views

import com.example.zoo.AppCore.Model.Exhibit

interface MainView:ViewBase {
     fun onLoadFinished(data:List<Exhibit>)
     fun onLoadError(error:String)
}