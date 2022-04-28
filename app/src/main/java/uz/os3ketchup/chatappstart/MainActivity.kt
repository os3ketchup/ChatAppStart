package uz.os3ketchup.chatappstart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.os3ketchup.chatappstart.adapter.MessageAdapter
import uz.os3ketchup.chatappstart.databinding.ActivityMainBinding
import uz.os3ketchup.chatappstart.models.Message

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        list.add(Message("Hi","1","2"))
        list.add(Message("Hello","2","1"))
        list.add(Message("How is it going","1","2"))
        list.add(Message("I am fine, and U","2","1"))
        list.add(Message("Thanks fine too","1","2"))

        binding.rvMessage.adapter = MessageAdapter(list)
    }
}