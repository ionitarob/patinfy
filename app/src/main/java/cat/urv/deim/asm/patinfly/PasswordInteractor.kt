package cat.urv.deim.asm.patinfly

class PasswordInteractor {
    interface OnPasswordListener{
        fun setPasswordError()
        fun setPasswordRepeatError()
        fun onSuccess()
    }

    fun createPassword(password: String, passwordRepeat: String, listener: OnPasswordListener): Boolean {
        var success = false

        if (password.isEmpty()){
            listener.setPasswordError()
        }
        if (passwordRepeat.isEmpty()) {
            listener.setPasswordRepeatError()
        }
        if (password.isNotEmpty() && passwordRepeat.isNotEmpty()){
            success = true
        }
        return success
    }
}