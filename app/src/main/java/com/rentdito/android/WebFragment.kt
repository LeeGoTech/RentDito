package com.rentdito.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.hotwire.turbo.errors.TurboVisitError
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/web")
class WebFragment : TurboWebFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.web_fragment, container, false)
    }

    @SuppressLint("InflateParams")
    override fun createProgressView(location: String): View {
        return layoutInflater.inflate(R.layout.turbo_progress, null)
    }

    @SuppressLint("InflateParams")
    override fun createErrorView(error: TurboVisitError): View {
        return layoutInflater.inflate(R.layout.error_web_fragment, null)
    }

    override fun shouldObserveTitleChanges(): Boolean {
        return false
    }
}