package com.example.testkoin.ui.screens.main

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testkoin.R
import com.example.testkoin.models.SomeModel
import com.example.testkoin.ui.screens.main.recycler_view.adapters.SomeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.java.KoinJavaComponent.getKoin

class MainActivity : MvpAppCompatActivity(), MainView {

    lateinit var adapter: SomeAdapter

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = getKoin().get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = SomeAdapter()
        rvContent.adapter = adapter
    }

    override fun loadData(data: List<SomeModel>) {
        adapter.addItems(data)
    }

}