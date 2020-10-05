package com.example.testkoin.ui.screens.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.testkoin.repository.SomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@InjectViewState
class MainPresenter(
    private val someRepository: SomeRepository
) : MvpPresenter<MainView>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Main + job

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        fetchSomeData()
    }

    private fun fetchSomeData() {
        launch(job) {
            val data = someRepository.fetchSomeDataAsync()
            launch(Main) {
                data.await().body()?.data?.let {
                    viewState.loadData(it)
                }
            }
        }
    }

    override fun onDestroy() {
        job.cancel()
    }

}