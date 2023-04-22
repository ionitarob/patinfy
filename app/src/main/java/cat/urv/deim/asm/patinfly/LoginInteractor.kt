package cat.urv.deim.asm.patinfly

class LoginInteractor {
    interface OnLoginListener {
        fun emptyTextError()
        fun onSuccess()
    }

    interface OnSignUpListener {
        fun onSignUp()
    }

    fun login(username: String, password: String, listener: OnLoginListener): Boolean {
        return if (username.isNotEmpty() && password.isNotEmpty()){
            true
        }
        else{
            listener.emptyTextError()
            false
        }
    }
}