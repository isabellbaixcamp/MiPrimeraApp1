package org.insbaixcamp.miprimeraapp

import android.widget.TextView
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
            // la clase recibe como parámetro una view que hereda de una RecyclerView
class TaskViewHolder (view: View):RecyclerView.ViewHolder(view)// clase creada para el viewholder
{
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val ivTaskHecha:ImageView = view.findViewById(R.id.tvTask)

    fun devuelve(task:String, onItemDone: (Int) -> Unit) {
        tvTask.text = task                  //el adapter retorna la posicion en la que nos encontramos
        ivTaskHecha.setOnClickListener { onItemDone(adapterPosition)}
    }
}