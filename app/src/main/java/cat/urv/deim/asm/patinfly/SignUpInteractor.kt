package cat.urv.deim.asm.patinfly

class SignUpInteractor {
    interface OnSignupListener {
        fun emptyTextError()
        fun onSuccess()
    }

    fun signUp(firstName: String, lastName: String, email: String, phone: Int?, id: String, nationality: String, listener: OnSignupListener): Boolean {
        return if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() &&
            phone != null && id.isNotEmpty() && nationality.isNotEmpty()){
            true
        }
        else {
            listener.emptyTextError()
            false
        }

    }
}