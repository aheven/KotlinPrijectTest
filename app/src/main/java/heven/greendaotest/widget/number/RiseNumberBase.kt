package heven.greendaotest.widget.number

interface RiseNumberBase {
    fun start()

    fun withNumber(number: Float, fromNumber: Float = 0f): RiseNumberTextView

    fun withNumber(number: Int, fromNumber: Int = 0): RiseNumberTextView

    fun setDuration(duration: Long): RiseNumberTextView

    fun setOnEnd(endListener: RiseNumberTextView.EndListener)
}