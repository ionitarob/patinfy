package cat.urv.deim.asm.patinfly

import java.util.Date

data class Scooter(
    val uuid: String,
    val longitude: String,
    val latitude: String,
    val battery: Int,
    val meters_rec: Int,
    val dataInc: Date,
    val dataMan: Date,
    val estate: String,
    val free: Boolean
    )