package cat.urv.deim.asm.patinfly

class ScooterRepository{
    private val scooterList = mutableListOf<Scooter>()

    fun addScooter(scooter: Scooter){
        scooterList.add(scooter)
    }

    fun activeScooters(): MutableList<Scooter>{
        val activeScooterList = mutableListOf<Scooter>()
        for (Scooter in scooterList){
            if (Scooter.estate == "Active"){
                addScooter(Scooter)
            }
        }
        return activeScooterList
    }
}