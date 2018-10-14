package com.example.teplo.newsapp.presentation.about

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.teplo.newsapp.R
import kotlinx.android.synthetic.main.fragment_about.*

class AboutAsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.title = getString(R.string.title_about_as)
        initSendMessage()
    }

    private fun initSendMessage() {
        send_message.setOnClickListener {
            if (message.text.isEmpty())
                AlertDialog.Builder(activity)
                        .setTitle(getString(R.string.send_message_error_title))
                        .setMessage(getString(R.string.input_message))
                        .setCancelable(false)
                        .setNegativeButton(getString(R.string.okey)) { _, _ -> }
                        .show()
            else {
                val intent = Intent(Intent.ACTION_SENDTO)
                val uriText = "mailto:" + Uri.encode(getString(R.string.link_email)) +
                        "?subject=" + Uri.encode(getString(R.string.subject)) +
                        "&body=" + Uri.encode(message.text.toString())
                val uri = Uri.parse(uriText)
                intent.data = uri
                try {
                    startActivity(Intent.createChooser(intent, getString(R.string.send_mail_title)))
                } catch (ex: ActivityNotFoundException) {
                    Toast.makeText(activity,
                            getString(R.string.no_email_clients_installed),
                            Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
        icon_telegram.setOnClickListener { openSocial(getString(R.string.link_telegram)) }
        icon_instagram.setOnClickListener { openSocial(getString(R.string.link_instagram)) }
        createDisclaimer()
    }

    private fun createDisclaimer() {
        val disclaimer = TextView(context)
        disclaimer.text = getString(R.string.disclaimer)
        disclaimer.gravity = Gravity.CENTER_HORIZONTAL
        layout_disclaimer.addView(disclaimer)
    }

    private fun openSocial(link: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = (Uri.parse(link))
        startActivity(intent)
    }
}