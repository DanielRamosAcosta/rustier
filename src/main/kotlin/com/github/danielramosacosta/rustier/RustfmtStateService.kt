package com.github.danielramosacosta.rustier

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.project.Project

@State(name = "RustfmtStateService")
class RustfmtStateService(project: Project?) : PersistentStateComponent<RustfmtStateService.State> {
    companion object {
        fun getInstance(project: Project): RustfmtStateService {
            return ServiceManager.getService(project, RustfmtStateService::class.java)
        }
    }

    /*internal*/ class State {
        var userDefinedPath: String? = null
        var runForFilesGlob: String = "{**/*}.rs"

        fun getRusfmtPath(): String {
            return userDefinedPath ?: "/Users/danielramos/.cargo/bin/rustfmt"
        }
    }

    private var myState = State()

    override fun getState(): State {
        return myState
    }

    override fun loadState(state: State) {
        myState = state
    }

    fun setCustomUserPath(rustFmtPath: String) {
        this.state.userDefinedPath = rustFmtPath
    }

    fun getRusfmtPath(): String {
        return state.getRusfmtPath()
    }
}
