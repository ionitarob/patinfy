package cat.urv.deim.asm.patinfly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ScooterListAdapter(private val scooters: Scooters){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val root: View

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            root = view
        }
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = scooters.scooters.get(position).uuid
        viewHolder.root.setOnClickListener {
            Toast.makeText(viewHolder.root.context,
                "Row selected %d".format(position),
                Toast.LENGTH_LONG).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(){
        return scooters.scooters.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.scooter_item_list, viewGroup, false)

        return ViewHolder(view)
    }
}