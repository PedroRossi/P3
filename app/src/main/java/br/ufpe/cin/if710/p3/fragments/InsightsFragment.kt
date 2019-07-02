package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R

class InsightsFragment  : Fragment() {

    companion object {
        fun newInstance(): InsightsFragment {
            return InsightsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.insights, container, false)
    }
}