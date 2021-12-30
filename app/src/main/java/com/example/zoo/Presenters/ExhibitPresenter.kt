package com.example.zoo.Presenters

import com.example.zoo.AppCore.Model.Exhibit
import com.example.zoo.AppCore.Model.Plant
import com.example.zoo.Interactors.ExhibitInteractor
import com.example.zoo.Interactors.MainInteractor
import com.example.zoo.Views.ExhibitView
import com.example.zoo.Views.MainView

class ExhibitPresenter(private val view: ExhibitView):ExhibitInteractor.onFinishedLister{

    private var interactor:ExhibitInteractor = ExhibitInteractor()
    var plants:List<Plant> = listOf<Plant>()

    init{
        view.initView()
    }

    fun loadData(){
        view?.showLoading()
        interactor.loadData(this)
    }

    override fun onSuccess(data: List<Plant>) {
        view?.hideLoading()
        view?.onLoadFinished(data)
        this.plants = data
    }

    override fun onError(error: String) {
        view?.hideLoading()
        view?.onLoadError(error)

    }


}