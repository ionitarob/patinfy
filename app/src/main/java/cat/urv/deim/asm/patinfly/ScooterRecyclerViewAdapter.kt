package cat.urv.deim.asm.patinfly
import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

@SuppressLint("SetTextI18n")
class ScooterRecyclerViewAdapter(private val scooters: Scooters) :
    RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>(){

    var itemClick : ((ScooterDetailActivity) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val battery: TextView
        val root: View

        init {
            name = view.findViewById(R.id.elementName)
            battery = view.findViewById(R.id.elementBattery)
            root = view
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.scooter_item_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = "NAME: "+scooters.scooters[position].name.toString()
        viewHolder.battery.text = "BATTERY: "+scooters.scooters[position].battery_level.toString()
        viewHolder.root.setOnClickListener {
            val scooter = scooters.scooters[position]
            val intent = Intent(viewHolder.root.context, ScooterDetailActivity::class.java)
            intent.putExtra("uuid", scooter.uuid)
            intent.putExtra("name", scooter.name.toString())
            intent.putExtra("battery", scooter.battery_level.toString())
            intent.putExtra("latitude", scooter.latitude.toString())
            intent.putExtra("longitude", scooter.longitude.toString())
            intent.putExtra("km_use", scooter.km_use.toString())
            intent.putExtra("date", scooter.date_last_maintenance.toString())
            intent.putExtra("onRent", scooter.on_rent.toString())
            intent.putExtra("state", scooter.state.toString())
            viewHolder.root.context.startActivity(intent)
        }
    }
    override fun getItemCount() = scooters.scooters.size
}
