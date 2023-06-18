package cat.urv.deim.asm.patinfly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel {
    private val data = MutableLiveData<String>()

    fun setData(value: String) {
        data.value = value
    }

    fun getData(): LiveData<String> {
        return data
    }
}