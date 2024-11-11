package com.rentdito.android.main

import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rentdito.android.util.customUserAgent
import com.rentdito.android.util.initDayNightTheme
import dev.hotwire.strada.Bridge
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass
import com.rentdito.android.util.HOME_URL
import com.rentdito.android.web.WebBottomSheetFragment
import com.rentdito.android.web.WebFragment
import com.rentdito.android.web.WebHomeFragment
import com.rentdito.android.web.WebModalFragment

class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
    override val sessionName = "main"

    override val startLocation = HOME_URL

    override val registeredActivities: List<KClass<out AppCompatActivity>>
        get() = listOf(
            // Leave empty unless you have more
            // than one TurboActivity in your app
        )

    override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
            WebFragment::class,
            WebHomeFragment::class,
            WebModalFragment::class,
            WebBottomSheetFragment::class
        )

    override val pathConfigurationLocation: TurboPathConfiguration.Location
        get() = TurboPathConfiguration.Location(
            assetFilePath = "json/configuration.json",
        )

    override fun onSessionCreated() {
        super.onSessionCreated()

        session.webView.settings.userAgentString = session.webView.customUserAgent
        session.webView.initDayNightTheme()

        Bridge.initialize(session.webView)
    }
}