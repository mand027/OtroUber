package edu.daec.otrouber.fragmentos
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.daec.otrouber.R
import edu.daec.otrouber.modelo.DespensaFirebase
import edu.daec.otrouber.modelo.Item
import kotlinx.android.synthetic.main.*


class DespensaRecyclerAdapter( private val list: List<Item>)
    : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item = list[position]
        holder.bind(item)
        holder.itemView.setOnLongClickListener {
            val despensaFirebase = DespensaFirebase()
            despensaFirebase.borraUnItem(item)

            val contexto = it.context
            Toast.makeText(contexto,"Borraste "+ item.descripcion, Toast.LENGTH_LONG).show()
            true
        }

    }

    override fun getItemCount(): Int = list.size

}

class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.renglon_item, parent, false)) {
    private var cantidadItemTextView: TextView? = null
    private var itemDescripcionTextView: TextView? = null
    private var itemIDTextView: TextView? = null


    init {
        cantidadItemTextView = itemView.findViewById(R.id.item_cantidad)
        itemDescripcionTextView = itemView.findViewById(R.id.item_descipcion)
        itemIDTextView = itemView.findViewById(R.id.item_id)
    }

    fun bind(item: Item) {
        Log.i("Error despensa",item.cantidad.toString() )
        cantidadItemTextView?.text = item.cantidad.toString()
        itemDescripcionTextView?.text = item.descripcion
        itemIDTextView?.text = item.id
    }

}