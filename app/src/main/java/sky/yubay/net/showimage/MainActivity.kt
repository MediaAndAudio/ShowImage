package sky.yubay.net.showimage

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : Activity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //imageView显示图片
        imageview.setBackgroundResource(R.mipmap.ic_launcher)
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
//        holder.addCallback(this@MainActivity)
    }
}
