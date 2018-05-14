package heven.greendaotest.widget.number

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class RiseNumberTextView(context: Context, attrs: AttributeSet) : TextView(context, attrs), RiseNumberBase {

    private var mPlayingState = STOPPED
    /**
     * 1.int 2.float
     */
    private var numberType: Int = 2
    private var fromNumber: Float = 0f
    private var number: Float = 0f
    private var duration: Long = 1000L

    private var endListener: EndListener? = null

    interface EndListener {
        fun onEndFinish()
    }

    private val decimalFormat by lazy {
        DecimalFormat()
    }

    private fun isRunning(): Boolean = mPlayingState == RUNNING

    private fun runFloat() {
        val valueAnimator = ValueAnimator.ofFloat(fromNumber, number)
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener {
            text = format(",##0.00").format(valueAnimator.animatedValue)
            if (valueAnimator.animatedFraction >= 1) {
                mPlayingState = STOPPED
                endListener?.onEndFinish()
            }
        }
        valueAnimator.start()
    }

    private fun runInt() {
        val valueAnimator = ValueAnimator.ofInt(fromNumber.toInt(), number.toInt())
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener {
            text = valueAnimator.animatedValue.toString()
            if (it.animatedFraction >= 1) {
                mPlayingState = STOPPED
                endListener?.onEndFinish()
            }
        }
        valueAnimator.start()
    }

    private fun format(pattern: String): DecimalFormat {
        decimalFormat.roundingMode = RoundingMode.HALF_EVEN
        decimalFormat.applyPattern(pattern)
        return decimalFormat
    }

    override fun start() {
        if (!isRunning()) {
            mPlayingState = RUNNING
            if (numberType == 1)
                runInt()
            else
                runFloat()
        }
    }

    override fun withNumber(number: Float,fromNumber:Float): RiseNumberTextView {
        this.number = number
        numberType = 2
        this.fromNumber = fromNumber
        return this
    }

    override fun withNumber(number: Int,fromNumber: Int): RiseNumberTextView {
        this.number = number.toFloat()
        numberType = 1
        this.fromNumber = fromNumber.toFloat()
        return this
    }

    override fun setDuration(duration: Long): RiseNumberTextView {
        this.duration = duration
        return this
    }

    override fun setOnEnd(endListener: RiseNumberTextView.EndListener) {
        this.endListener = endListener
    }

    companion object {
        const val STOPPED = 0
        const val RUNNING = 1
    }
}