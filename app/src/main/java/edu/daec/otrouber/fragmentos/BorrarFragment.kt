package edu.daec.otrouber.fragmentos

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import edu.daec.otrouber.R
import edu.daec.otrouber.modelo.DespensaFirebase
import edu.daec.otrouber.modelo.Item
import kotlinx.android.synthetic.main.fragment_alta.*
import kotlinx.android.synthetic.main.fragment_borrar.*

/**
 * A simple [Fragment] subclass.
 */
class BorrarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        boton_editaritem.setOnClickListener{
            val despensaFirebase = DespensaFirebase()
            val item = Item()
            item.id = idnueva_edittext.text.toString()
            item.cantidad = cantidadnueva_edittext.text.toString().toInt()
            item.descripcion = descriptionnueva_edittext.text.toString()
            despensaFirebase.modificaUnItem(item)
            context!!.hideKeyboard(it)
        }

        button_borrar_todo.setOnClickListener{
            val despensaFirebase = DespensaFirebase()
            despensaFirebase.borraTodo()
        }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
