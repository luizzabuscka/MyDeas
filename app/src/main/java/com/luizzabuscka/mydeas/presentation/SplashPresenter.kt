package com.luizzabuscka.mydeas.presentation

import android.content.Context
import android.content.Intent
import com.luizzabuscka.mydeas.interactors.interfaces.ISplashInteractor
import com.luizzabuscka.mydeas.interactors.SplashInteractor
import com.luizzabuscka.mydeas.prefs
import com.luizzabuscka.mydeas.presentation.interfaces.ISplashPresenter
import com.luizzabuscka.mydeas.view.interfaces.ISplashActivity
import com.luizzabuscka.mydeas.view.LoginActivity
import com.luizzabuscka.mydeas.view.MainActivity

/**
 * Created by luizzabuscka on 02/08/17.
 */
class SplashPresenter(val context: Context, val activity: ISplashActivity) : ISplashPresenter {

  val interactor : ISplashInteractor = SplashInteractor(this, context)

  override fun callNextActivity() {
    if (!verifyLogged()) {
      activity.callNextActivity(Intent(context, LoginActivity::class.java))
    } else {
      activity.callNextActivity(Intent(context, MainActivity::class.java))
    }
  }

  override fun downloadLogins() {
    if (verifyLogged()) {
      callNextActivity()
    } else {
      interactor.downloadLogins()
    }
  }

  override fun verifyLogged() : Boolean {
    return prefs.logged
  }

}