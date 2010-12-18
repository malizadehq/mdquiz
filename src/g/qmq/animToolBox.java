package g.qmq;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class animToolBox {
	public final static int ZOOM_IN_CENTER = 0;
	
	public animToolBox() {
	}

	/**
	 * Quick animation
	 * @param mode ZOOM_IN_CENTER
	 * @param v View
	 */
	public animToolBox(int mode) {
		switch(mode){
		case 0:
			scaleMode = Animation.RELATIVE_TO_SELF;
			s1 = 0.5f;
			s2 = 0.5f;
			x1 = 1;
			x2 = 0;
			y1 = 1;
			y2 = 0;
			duration = 1000;
			return;
		}
	}
	
	/**
	 * ��������
	 * 
	 * @param v
	 *            View ����View
	 * @param fx
	 *            float X��ʼ
	 * @param tx
	 *            float X����
	 * @param fy
	 *            float y��ʼ
	 * @param ty
	 *            float y����
	 */
	public animToolBox(float fx, float tx, float fy, float ty) {
		x1 = fx;
		x2 = tx;
		y1 = fy;
		y2 = ty;
	}

	/**
	 * �����ƽ�/�� ִ��
	 * 
	 * @param v
	 *            View ����View
	 * @param direction
	 *            char ������������(t,b,l,r)
	 * @param out
	 *            boolean �Ƴ���Ļ.
	 */
	public animToolBox(View v, char direction, boolean out) {
		setDirection(direction, out);
		animMove(v);
	}

	/**
	 * �����ƽ�/�� ����
	 * 
	 * @param direction
	 *            char ������������(t,b,l,r)
	 * @param out
	 *            boolean �Ƴ���Ļ.
	 */
	public animToolBox(char direction, boolean out) {
		setDirection(direction, out);
	}

	/* �ƶ������� START */
	/**
	 * ��������
	 * 
	 * @param direction
	 *            char ������������(t,b,l,r)
	 * @param out
	 *            boolean �Ƴ���Ļ.
	 */
	public void setDirection(char direction, boolean out) {
		switch (direction) {
		case 'l':
			if (out) {
				x2 = -300;
			} else {
				x1 = -300;
			}
			break;
		case 'r':
			if (out) {
				x2 = 300;
			} else {
				x1 = 300;
			}
			break;
		case 't':
			if (out) {
				y2 = 500;
			} else {
				y1 = 500;
			}
			break;
		case 'b':
			if (out) {
				y2 = -500;
			} else {
				y1 = -500;
			}
			break;
		}
	}

	/**
	 * ִ���ƶ�
	 * 
	 * @param v
	 *            View �ؼ�
	 */
	public void animMove(View v) {
		Animation anim = null;
		anim = new TranslateAnimation(x1, x2, y1, y2);
		anim.setInterpolator(new AccelerateDecelerateInterpolator());
		anim.setDuration(duration);
		anim.setFillAfter(fill);
		anim.setStartOffset(delate);
		v.startAnimation(anim);
	}

	/* �ƶ������� END */

	/* ���Ŷ����� START */
	/**
	 * ��������ģʽ
	 * 
	 * @param mode
	 *            int Animation.ABSOLUTE; Animation.RELATIVE_TO_SELF;
	 *            Animation.RELATIVE_TO_PARENT;
	 */
	public void setScaleMode(int mode) {
		scaleMode = mode;
	}

	/**
	 * ִ������
	 * 
	 * @param v
	 *            View �ؼ�
	 */
	public void animScale(View v) {
		Animation anim = null;
		anim = new ScaleAnimation(x1, x2, y1, y2, scaleMode, s1, scaleMode, s2);
		anim.setInterpolator(new AccelerateDecelerateInterpolator());
		anim.setDuration(duration);
		anim.setFillAfter(fill);
		anim.setStartOffset(delate);
		v.startAnimation(anim);
	}

	public void setS(float sS1, float sS2) {
		s1 = sS1;
		s2 = sS2;
	}

	/* ���Ŷ����� END */

	/**
	 * �ӳٿ�ʼ
	 * 
	 * @param sDelate
	 *            long �ӳ�ʱ��(����)
	 */
	public void setDelate(long sDelate) {
		delate = sDelate;
	}

	/**
	 * ���ö�����������
	 * 
	 * @param nDuratio
	 *            long ����
	 */
	public void setTime(long nDuration) {
		duration = nDuration;
	}

	/**
	 * ���ö�����������
	 * 
	 * @param nDuratio
	 *            long ����
	 */
	public void setFill(boolean sfill) {
		fill = sfill;
	}

	public void setXY(float sX1, float sX2, float sY1, float sY2) {
		x1 = sX1;
		x2 = sX2;
		y1 = sY1;
		y2 = sY2;
	}

	private int scaleMode = 0;
	private float x1 = 0, x2 = 0, y1 = 0, y2 = 0, s1 = 0, s2 = 0;
	private long duration = 1000, delate = 0;
	private boolean fill = true;
	public Animation AM;
}
