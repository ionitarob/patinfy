package cat.urv.deim.asm.patinfly

class LoginInteractor {
    interface OnLoginListener {
        fun setUserError()
        fun setPasswordError()
        fun onSuccess()
    }

    interface OnSignUpListener {
        fun onSignUp()
    }

    fun login(username: String, password: String, listener: OnLoginListener): Boolean {
        var success = false

        if (username.isEmpty()){
            listener.setUserError()
        }
        if (password.isEmpty()){
            listener.setPasswordError()
        }
        if (username.isNotEmpty() && password.isNotEmpty()){
            success = true
        }
        return success
    }
}