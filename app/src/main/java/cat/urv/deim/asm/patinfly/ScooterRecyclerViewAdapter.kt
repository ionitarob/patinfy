package cat.urv.deim.asm.patinfly
import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScooterRecyclerViewAdapter(private val scooters: Scooters) :
    RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>(){

    var itemClick : ((ScooterDetailActivity) -> Unit)? = null

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
            val scooter = scooters.scooters[position]
            val intent = Intent(viewHolder.root.context, ScooterDetailActivity::class.java)
            intent.putExtra("uuid", scooter.uuid)
            intent.putExtra("name", scooter.name)
            intent.putExtra("battery", scooter.battery_level)
            intent.putExtra("latitude", scooter.latitude)
            intent.putExtra("longitude", scooter.longitude)
            intent.putExtra("km_use", scooter.km_use)
            intent.putExtra("date", scooter.date_last_maintenance)
            intent.putExtra("on_rent", scooter.on_rent)
            intent.putExtra("state", scooter.state)
            viewHolder.root.context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = scooters.scooters.size
}
