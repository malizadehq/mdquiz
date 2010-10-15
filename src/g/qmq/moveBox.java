package g.qmq;

import android.graphics.PointF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class moveBox {
	/**
	 * �������캯��.
	 */
	public moveBox() {
	}

	/**
	 * �����ƶ���������.
	 * 
	 * @param view
	 *            ָ��������VIEW
	 * @param x1
	 *            X��ʼλ��
	 * @param y1
	 *            Y��ʼλ��
	 * @param x2
	 *            X����λ��
	 * @param y2
	 *            Y����λ��
	 */
	public moveBox(float x1, float y1, float x2, float y2) {
		sP.set(x1, y1);
		eP.set(x2, y2);
		i = new AccelerateDecelerateInterpolator();
	}

	public void start(View v, Animation a) {
		a = new TranslateAnimation(sP.x, eP.x, sP.y, eP.y);
		a.setInterpolator(i);
		a.setDuration(duration);
		a.setFillAfter(fill);
		a.setStartOffset(delate);
		v.startAnimation(a);
	}

	public void setDuration(long d) {
		duration = d;
	}

	public void setDelate(long d) {
		delate = d;
	}

	public int scaleMode = 0;
	public PointF sP, eP;
	private long duration = 1000, delate = 0;
	public boolean fill = true;
	public Interpolator i;
}
