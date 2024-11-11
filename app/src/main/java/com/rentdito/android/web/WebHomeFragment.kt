package com.rentdito.android.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rentdito.android.R
import dev.hotwire.turbo.nav.TurboNavGraphDestination
import dev.hotwire.turbo.errors.TurboVisitError

@TurboNavGraphDestination(uri = "turbo://fragment/web/home")
class WebHomeFragment : WebFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.web_fragment, container, false)
    }

    @SuppressLint("InflateParams")
    override fun createErrorView(error: TurboVisitError): View {
        return layoutInflater.inflate(R.layout.error_web_fragment, null)
    }

    override fun shouldObserveTitleChanges(): Boolean {
        return false
    }
}