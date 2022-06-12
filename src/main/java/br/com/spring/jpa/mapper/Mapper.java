package br.com.spring.jpa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Mapper extends ModelMapper {

	private ModelMapper modelMapper;
	
	public Mapper() {
		this.modelMapper = new ModelMapper();
	}
	
	/**Map to convert DTO or Entity from collection 
	 * @param <S> source  
	 * @param <T> targetClass
	 * @return {@code source}
	 */
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	/**Map to convert DTO or Entity from single object 
	 * @param <S> source  
	 * @param <T> targetClass
	 * @return {@code source}
	 */
	public <D> D map(Object source, Class<D> destinationType) {
		return super.map(source, destinationType);
	}
}
