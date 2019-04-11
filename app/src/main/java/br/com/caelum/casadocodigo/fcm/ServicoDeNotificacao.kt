package br.com.caelum.casadocodigo.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.activity.CarrinhoActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class ServicoDeNotificacao : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        val manager = NotificationManagerCompat.from(this)

        criandoChannel(manager)

        val procuracao: PendingIntent = criandoPendingIntent()

        val notification = criaNotificacao(procuracao)

        manager.notify(456, notification)

    }
    private fun criaNotificacao(procuracao: PendingIntent): Notification {
        return NotificationCompat.Builder(this, "cdc_notificacoes")
            .setContentTitle("Chegou uma novidade para você")
            .setContentText("Você foi mega premiado no app, clique aqui e veja o que voce ganhou")
            .setContentIntent(procuracao)
            .setSmallIcon(R.drawable.ic_book)
            .setAutoCancel(true)
            .build()
    }
    private fun criandoPendingIntent(): PendingIntent {
        return PendingIntent.getActivity(
            this,
            123,
            Intent(this, CarrinhoActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
    private fun criandoChannel(manager: NotificationManagerCompat) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "cdc_notificacoes",
                "Channel de novidades",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Aqui voce recebera cupons de desconto"
            manager.createNotificationChannel(channel)
        }
    }


}