package com.example.testkoin.ui.screens.main

import com.arellomobile.mvp.MvpView
import com.example.testkoin.models.SomeModel

interface MainView : MvpView {

    fun loadData(data: List<SomeModel>)

}
