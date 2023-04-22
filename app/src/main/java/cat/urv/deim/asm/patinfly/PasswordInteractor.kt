package cat.urv.deim.asm.patinfly

class PasswordInteractor {
    interface OnPasswordListener{
        fun emptyTextError()
        fun onSuccess()
    }

    fun createPassword(password: String, passwordRepeat: String, listener: OnPasswordListener): Boolean {
        return if (password.isNotEmpty() && passwordRepeat.isNotEmpty()){
            true
        }
        else{
            listener.emptyTextError()
            false
        }
    }
}