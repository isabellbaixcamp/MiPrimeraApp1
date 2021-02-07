package org.insbaixcamp.miprimeraapp

import android.app.Application

class Aplicacion:Application() {

   companion object{
       lateinit var prefs:Preferencias
   }
    override fun onCreate() {
        super.onCreate()
        prefs = Preferencias(baseContext)
    }
}