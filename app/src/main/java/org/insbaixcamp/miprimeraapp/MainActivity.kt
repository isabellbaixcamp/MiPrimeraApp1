package org.insbaixcamp.miprimeraapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText  // version con git
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.insbaixcamp.miprimeraapp.TasApplication.Companion.prefs

class MainActivity : AppCompatActivity() {
    lateinit var buttonAddTask: Button // lateinit refiere al inicio luego de tal variable
    lateinit var etTask: EditText
    lateinit var rvTask: RecyclerView

    lateinit var adapter:TaskAdapter

    var task = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         // llama al método o función definida
        initVi()
        prefs
    }

     private fun initVi() {// funcion debe definir variables y tipos
         initView()     // refiere a otra función que instanciará a alos valores
                            // los "val" (valores en kotlin no pueden ser reasignados
         initListeners()
         initRecyclerView()
     }

    private fun initRecyclerView() {
        task = prefs.getTask()
        rvTask.layoutManager = LinearLayoutManager( this)
        adapter= TaskAdapter(task, {borraTask(it)})
        rvTask.adapter = adapter
    }

    private fun borraTask(position: Int){
        task.removeAt(position)  // declara la eliminacion del elemento
        adapter.notifyDataSetChanged() // adaptador notifica el cambio
        prefs.saveInformation(task)
    }
    private fun initListeners() {
        buttonAddTask.setOnClickListener {  // refiere que cada vez que sea pulsado el button
            addTask()   // hace el llamado a la función addtask
        }
    }

    private fun addTask() {
        val taskToAdd:String = etTask.text.toString()   // cada punto refiere al retorno de un id, de un texto a un String
        task.add(taskToAdd)   // con este comando adjunta las tareas que se deseen en la list
        adapter.notifyDataSetChanged()
        etTask.setText("")
        prefs.saveInformation(task)
    }
    @SuppressLint("ResourceType")
     private fun initView() {
         buttonAddTask = findViewById(R.id.buttonAddTask)
         etTask = findViewById(R.id.etTask)
         rvTask = findViewById(R.id.rvTask)

     }

}