/**
 * Copyright (C) 2016 LibRec
 * 
 * This file is part of LibRec.
 * LibRec is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LibRec is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LibRec. If not, see <http://www.gnu.org/licenses/>.
 */
package net.librec.similarity;

import java.util.List;

/**
 * Extend Jaccard Coefficient
 * 
 * @author zhanghaidong
 *
 */
public class ExJaccardSimilarity extends AbstractRecommenderSimilarity {
	
	/**
	 * calculate extend Jaccard Coefficient between two vectors of ratings
	 */
	protected double getSimilarity(List<? extends Number> thisList, List<? extends Number> thatList) {
		
		double innerProduct = 0.0, thisPower2 = 0.0, thatPower2 = 0.0;
		for (int i = 0; i < thisList.size(); i++) {
			double thisValue = thisList.get(i).doubleValue();
			double thatValue = thatList.get(i).doubleValue();
			
			innerProduct += thisValue * thatValue;
			thisPower2 += thisValue * thisValue;
			thatPower2 += thatValue * thatValue;
		}
		
		return innerProduct / (thisPower2 + thatPower2 - innerProduct);	
	}
}