package org.insbaixcamp.miprimeraapp

import android.content.Context
import android.content.SharedPreferences

class Preferencias (context: Context) {  // se ubicará la lógica de la SharedReferences
    companion object {
        const val PRES_NAME = "myDatabase" // las constantes se habituan a colocar en mayúsculas
        //const val VALUE = "value"
        const val TASK = "task_value"
    }

    val prefs: SharedPreferences = context.getSharedPreferences(PRES_NAME, 0)

    fun saveInformation(task:List<String>){
        prefs.edit().putStringSet(TASK, task.toSet()).apply() // guarada una lista de información
        //prefs.edit().putString(VALUE, "example").apply()  // el llamado al apply condiciona el guardado
    }

    fun getTask():MutableList<String>{
        return prefs.getStringSet(TASK, emptySet<String>())?.toMutableList()?: mutableListOf()//("NAME", "Anonimo") ?: "Anonimo"

    }
}
