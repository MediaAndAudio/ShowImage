package sky.yubay.net.showimage

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textvew1.text = "imageView显示图片"
        //imageView显示图片
        imageview.setBackgroundResource(R.mipmap.ic_launcher)

        textvew2.text = "sufaceView 显示图片"
        //sufaceView 显示图片
        val holder = surfaceView.holder
        holder.addCallback(object:SurfaceHolder.Callback{
            override  fun surfaceChanged(arg0: SurfaceHolder, arg1: Int, arg2: Int,
                               arg3: Int) {
            }
            override fun surfaceCreated(holder: SurfaceHolder) {
                // 锁定整个SurfaceView
                val canvas = holder.lockCanvas()
                // 绘制背景
                val back = BitmapFactory.decodeResource(
                        resources, R.mipmap.ic_launcher)
                //绘制背景
                canvas.drawBitmap(back, 0f, 0f, null)
                // 绘制完成，释放画布，提交修改
                holder.unlockCanvasAndPost(canvas)
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {}
        })

        textvew3.text = "自定义View 显示图片"
        button.text = "show"
        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Hello, ${textvew3.text}!",Toast.LENGTH_LONG).show()
        })

    }
}
