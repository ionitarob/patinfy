package cat.urv.deim.asm.patinfly
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ScooterRecyclerViewAdapter(private val scooters: Scooters) :
    RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val battery: TextView
        val root: View

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.elementName)
            battery = view.findViewById(R.id.elementBattery)
            root = view
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.scooter_item_list, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.name.text = "NAME: "+scooters.scooters[position].name.toString()
        viewHolder.battery.text = "BATTERY: "+scooters.scooters[position].battery_level.toString()
        viewHolder.root.setOnClickListener {
            Toast.makeText(viewHolder.root.context,
                "Row selected %d".format(position),
                Toast.LENGTH_LONG).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = scooters.scooters.size

}
