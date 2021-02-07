package org.insbaixcamp.miprimeraapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// el parámetro indica el listado de Strings que recibirá del mainActivity
                                                    // el segundo parametro es una funcion que retorna el elemento a eliminar (posicion)
class TaskAdapter (private val tasks:List<String>, private val onItemDone: (Int) -> Unit):RecyclerView.Adapter<TaskViewHolder> () {
    // conecta el viewHolder con el mainActivity   // herencia del recyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
                // función que crea el viewHolder
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)   // clase que permite cargar para  trabajar los xml
        return TaskViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount() = tasks.size // se adecua al tamanyo del listado

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.devuelve(tasks[position], onItemDone) // devuelve la posicion correspondiente
    }


}