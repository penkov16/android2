package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.netology.nmedia.databinding.ActivityMainBinding
import kotlin.math.ln
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            shareByMe = false
        )
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            if (post.likedByMe) {
                likes?.setImageResource(R.drawable.ic_liked_24)
            }
            numberLikes?.text = post.likes.toString()
            numberShare?.text = post.share.toString()

            root.setOnClickListener {
                Log.d("stuff", "stuff")
            }

            avatar.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            share?.setOnClickListener {
                post.shareByMe = !post.shareByMe
                post.share++
                val shareLong = post.share.toLong()
                //numberShare?.text = post.share.toString()
                numberShare?.text = getFormatedNumber(shareLong)
            }

            likes?.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                likes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like
                )
                if (post.likedByMe) post.likes++ else post.likes--
                val likesLong = post.likes.toLong()
                //numberLikes?.text = post.likes.toString()
                numberLikes?.text = getFormatedNumber(likesLong)
            }

        }

    }
    fun getFormatedNumber(count: Long): String {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "KMGTPE"[exp - 1])
    }

}