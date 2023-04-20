package cat.urv.deim.asm.patinfly

class PasswordPresenter( private var PasswordView: PasswordView?, private var PasswordInteractor: PasswordInteractor):
    PasswordInteractor.OnPasswordListener {
        fun verifyPassword(password: String, passwordRepeat: String): Boolean{
            PasswordView?.showProgress()
            return PasswordInteractor.createPassword(password, passwordRepeat, this)
        }

        override fun setPasswordError() {
            PasswordView?.apply {
                setPasswordError()
                hideProgress()
            }
        }

        override fun setPasswordRepeatError() {
            PasswordView?.apply {
                setPasswordRepeatError()
                hideProgress()
            }
        }

        override fun onSuccess() {
            PasswordView?.navigateToProfile()
        }
    }