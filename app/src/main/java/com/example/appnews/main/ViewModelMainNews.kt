package com.example.appnews.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMainNews @Inject constructor(private val repositoryMainNews: RepositoryMainNews) : ViewModel() {

}