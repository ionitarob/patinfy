package cat.urv.deim.asm.patinfly
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ScooterRecyclerViewAdapter(private val scooters: ArrayList<String>) :
        RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {

        val name = ArrayList<String>()
        val battery = ArrayList<String>()
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameText: TextView
            val batteryText : TextView
            val root: View

            init {
                // Define click listener for the ViewHolder's View.
                nameText = view.findViewById(R.id.elementName)
                batteryText = view.findViewById(R.id.elementBattery)
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
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.nameText.setText(name.get(position))
            viewHolder.batteryText.setText(battery.get(position))
            viewHolder.root.setOnClickListener {
                Toast.makeText(viewHolder.root.context,
                    "Row selected %d".format(position),
                    Toast.LENGTH_LONG).show()
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = scooters.size

    }
