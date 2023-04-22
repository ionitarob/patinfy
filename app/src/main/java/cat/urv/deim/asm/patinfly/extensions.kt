@file:Suppress("DEPRECATION")

package cat.urv.deim.asm.patinfly

import android.os.Handler
fun postDelayed(delayMillis: Long, task: () -> Unit) {
    Handler().postDelayed(task, delayMillis)
}
