package cat.urv.deim.asm.patinfly

class SignUpPresenter(private var SignUpView: SignUpView?, private var SignUpInteractor: SignUpInteractor):
    SignUpInteractor.OnSignupListener{

    fun verifyData(firstName: String, lastName: String, email: String, phone: Int?, id: String, nationality: String): Boolean{
        return SignUpInteractor.signUp(firstName, lastName, email, phone, id, nationality,this)
    }

    override fun emptyTextError() {
        SignUpView?.apply {
            emptyTextError()
            hideProgress()
        }
    }

    override fun onSuccess(){
        SignUpView?.navigateToPassword()
    }

}