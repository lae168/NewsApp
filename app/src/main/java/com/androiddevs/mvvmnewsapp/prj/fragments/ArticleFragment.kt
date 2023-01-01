package com.androiddevs.mvvmnewsapp.prj.fragments

import android.os.Bundle
import android.view.View


import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.prj.NewsActivity
import com.androiddevs.mvvmnewsapp.prj.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {


    lateinit var viewModel: NewsViewModel

    val args : ArticleFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        article?.let { news ->

//            apply = apply the following assignments to the object
//            apply for code blocks that don't return a value and mainly operate on the
//            members of the receiver object.
            webView.apply {
                webViewClient = WebViewClient()
                loadUrl(article?.url.toString())
//            }

                fab.setOnClickListener {

                    viewModel.saveArticle(article)

                    Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
                }
            }

        }
    }
}