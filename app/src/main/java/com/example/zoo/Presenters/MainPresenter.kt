package com.example.zoo.Presenters

import com.example.zoo.AppCore.Model.Exhibit
import com.example.zoo.Interactors.MainInteractor
import com.example.zoo.Views.MainView
import com.google.gson.Gson

class MainPresenter(private val view: MainView):MainInteractor.onFinishedLister{

    private var interactor:MainInteractor = MainInteractor()
    var exhibitList:List<Exhibit> = listOf<Exhibit>()

    init{
        view.initView()
    }

    fun loadData(){
        view?.showLoading()
        interactor.loadData(this)
    }

    override fun onSuccess(data: List<Exhibit>) {
        view?.hideLoading()
        view?.onLoadFinished(data)
        this.exhibitList = data
    }

    override fun onError(error: String) {
        view?.hideLoading()
        view?.onLoadError(error)

    }


}