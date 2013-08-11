package org.javers.model.mapping;

import org.fest.assertions.api.Assertions;
import org.javers.core.model.DummyUser;
import org.javers.model.mapping.type.ArrayType;
import org.javers.model.mapping.type.CollectionType;
import org.javers.model.mapping.type.ContainerType;
import org.javers.model.mapping.type.PrimitiveType;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

/**
 * @author bartosz walacik
 */
public abstract class EntityConstructionTest {
    protected EntityFactory entityFactory;

    @Test
    public void shouldHoldReferenceToSourceClass() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasSourceClass(DummyUser.class);
    }

    @Test
    public void shouldScanProperties() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        Assertions.assertThat(entity.getProperties()).hasSize(8);
    }

    @Test
    public void shouldScanSetProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("stringSet")
                .hasJaversType(CollectionType.class)
                .hasJavaType(Set.class);
    }

    @Test
    public void shouldScanListProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("integerList")
                .hasJaversType(CollectionType.class)
                .hasJavaType(List.class);
    }

    @Test
    public void shouldScanArrayProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("intArray")
                .hasJaversType(ArrayType.class)
                .hasJavaType(Array.class);
    }


    @Test
    public void shouldScanIntProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("age")
                .hasJaversType(PrimitiveType.class)
                .hasJavaType(Integer.TYPE);
    }

    @Test
    public void shouldScanIntegerProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("largeInt")
                .hasJaversType(PrimitiveType.class)
                .hasJavaType(Integer.class);
    }

    @Test
    public void shouldScanBooleanProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("flag")
                .hasJaversType(PrimitiveType.class)
                .hasJavaType(Boolean.TYPE);
    }

    @Test
    public void shouldScanBigBooleanProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("bigFlag")
                .hasJaversType(PrimitiveType.class)
                .hasJavaType(Boolean.class);
    }

    @Test
    public void shouldScanStringProperty() {
        //when
        Entity entity = entityFactory.create(DummyUser.class);

        //then
        EntityAssert.assertThat(entity).hasProperty("name")
                .hasJaversType(PrimitiveType.class)
                .hasJavaType(String.class);
    }
}